package com.bankapi;

import com.bankapi.dao.AccountDaoInMemoryImpl;
import com.bankapi.exception.AbstractCustomRuntimeException;
import com.bankapi.resource.MoneyTransferResource;
import com.bankapi.service.AccountServiceImpl;

import java.math.BigDecimal;

import static spark.Spark.exception;
import static spark.Spark.post;

public class BankApi {
    public static void main(String[] args) {
        MoneyTransferResource moneyTransferResource = new MoneyTransferResource(new AccountServiceImpl(new AccountDaoInMemoryImpl()));
        post("/bankapi/transfers/from/:from/to/:to/:amount", (request, response) ->
                moneyTransferResource.transferMoney(request.params(":from"), request.params(":to"), new BigDecimal(request.params(":amount"))));

        exception(AbstractCustomRuntimeException.class, (exception, request, response) -> {
            response.status(400);
            response.body(exception.getMessage());
        });

        exception(RuntimeException.class, (exception, request, response) -> {
            response.status(400);
            response.body("An unexpected error occurred");
        });
    }
}
