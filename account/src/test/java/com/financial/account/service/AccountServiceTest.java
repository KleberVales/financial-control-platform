package com.financial.account.service;

import com.financial.account.domain.Account;
import com.financial.account.domain.AccountType;
import com.financial.account.dto.AccountRequestDTO;
import com.financial.account.repository.AccountRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AccountServiceTest {

    @Mock
    private AccountRepository repository;

    @InjectMocks
    private AccountService service;

    @Test
    void shouldCreateAccountWithZeroBalance() {
        UUID userId = UUID.randomUUID();

        AccountRequestDTO dto = new AccountRequestDTO();
        dto.setName("Conta Teste");
        dto.setType(AccountType.CHECKING);
        dto.setUserId(userId);

        when(repository.save(any(Account.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        Account account = service.create(dto);

        assertNotNull(account);
        assertEquals("Conta Teste", account.getName());
        assertEquals(AccountType.CHECKING, account.getType());
        assertEquals(BigDecimal.ZERO, account.getBalance());
        assertEquals(userId, account.getUserId());

        verify(repository, times(1)).save(any(Account.class));
    }

    @Test
    void shouldReturnAccountsByUser() {
        UUID userId = UUID.randomUUID();

        Account account = new Account("Conta 1", AccountType.SAVINGS, userId);

        when(repository.findByUserId(userId))
                .thenReturn(List.of(account));

        List<Account> accounts = service.findByUser(userId);

        assertEquals(1, accounts.size());
        assertEquals("Conta 1", accounts.get(0).getName());

        verify(repository, times(1)).findByUserId(userId);
    }

    @Test
    void shouldReturnAccountById() {
        UUID id = UUID.randomUUID();
        Account account = new Account("Conta X", AccountType.WALLET, UUID.randomUUID());

        when(repository.findById(id))
                .thenReturn(Optional.of(account));

        Account result = service.findById(id);

        assertNotNull(result);
        assertEquals("Conta X", result.getName());

        verify(repository, times(1)).findById(id);
    }

    @Test
    void shouldThrowExceptionWhenAccountNotFound() {
        UUID id = UUID.randomUUID();

        when(repository.findById(id))
                .thenReturn(Optional.empty());

        RuntimeException exception = assertThrows(RuntimeException.class,
                () -> service.findById(id));

        assertEquals("Account not found", exception.getMessage());

        verify(repository, times(1)).findById(id);
    }
}

