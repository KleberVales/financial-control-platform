package com.financial.transaction.service;

import com.financial.transaction.domain.model.Transaction;
import com.financial.transaction.domain.model.TransactionType;
import com.financial.transaction.domain.repository.TransactionRepository;
import com.financial.transaction.dto.TransactionRequestDTO;
import com.financial.transaction.dto.TransactionResponseDTO;
import com.financial.transaction.exception.TransactionException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransactionServiceTest {

    @Mock
    private TransactionRepository repository;

    @InjectMocks
    private TransactionService service;

    private TransactionRequestDTO request;

    @BeforeEach
    void setup() {
        request = new TransactionRequestDTO();
        request.setDescription("Salário");
        request.setAmount(new BigDecimal("1000.00"));
        request.setType(TransactionType.INCOME);
        request.setAccountId(1L);
    }

    @Test
    void shouldCreateTransactionSuccessfully() {

        Transaction savedTransaction =
                new Transaction("Salário",
                        new BigDecimal("1000.00"),
                        TransactionType.INCOME,
                        1L);

        savedTransaction.complete();

        when(repository.save(any(Transaction.class)))
                .thenReturn(savedTransaction);

        TransactionResponseDTO response = service.create(request);

        assertNotNull(response);
        assertEquals("Salário", response.getDescription());
        assertEquals(TransactionType.INCOME, response.getType());

        verify(repository, times(1)).save(any(Transaction.class));
    }

    @Test
    void shouldThrowExceptionWhenAmountIsZero() {

        request.setAmount(BigDecimal.ZERO);

        assertThrows(TransactionException.class,
                () -> service.create(request));

        verify(repository, never()).save(any());
    }

    @Test
    void shouldReturnTransactionsByAccount() {

        Transaction transaction =
                new Transaction("Aluguel",
                        new BigDecimal("1500.00"),
                        TransactionType.EXPENSE,
                        1L);

        when(repository.findByAccountId(1L))
                .thenReturn(List.of(transaction));

        List<TransactionResponseDTO> result =
                service.findByAccount(1L);

        assertEquals(1, result.size());
        assertEquals("Aluguel", result.get(0).getDescription());

        verify(repository, times(1)).findByAccountId(1L);
    }
}

