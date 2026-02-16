package com.financial.transaction.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.financial.transaction.domain.model.TransactionStatus;
import com.financial.transaction.domain.model.TransactionType;
import com.financial.transaction.dto.TransactionRequestDTO;
import com.financial.transaction.dto.TransactionResponseDTO;
import com.financial.transaction.service.TransactionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(TransactionController.class)
class TransactionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TransactionService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldCreateTransaction() throws Exception {

        TransactionRequestDTO request = new TransactionRequestDTO();
        request.setDescription("Salário");
        request.setAmount(new BigDecimal("1000.00"));
        request.setType(TransactionType.INCOME);
        request.setAccountId(1L);

        TransactionResponseDTO response = new TransactionResponseDTO();
        response.setId(1L);
        response.setDescription("Salário");
        response.setAmount(new BigDecimal("1000.00"));
        response.setType(TransactionType.INCOME);
        response.setStatus(TransactionStatus.COMPLETED);
        response.setAccountId(1L);
        response.setCreatedAt(LocalDateTime.now());

        when(service.create(any(TransactionRequestDTO.class)))
                .thenReturn(response);

        mockMvc.perform(post("/transactions")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.description").value("Salário"))
                .andExpect(jsonPath("$.type").value("INCOME"));
    }

    @Test
    void shouldReturnTransactionsByAccount() throws Exception {

        TransactionResponseDTO response = new TransactionResponseDTO();
        response.setId(1L);
        response.setDescription("Aluguel");
        response.setAmount(new BigDecimal("1500.00"));
        response.setType(TransactionType.EXPENSE);
        response.setStatus(TransactionStatus.COMPLETED);
        response.setAccountId(1L);
        response.setCreatedAt(LocalDateTime.now());

        when(service.findByAccount(1L))
                .thenReturn(List.of(response));

        mockMvc.perform(get("/transactions/account/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].description").value("Aluguel"));
    }
}

