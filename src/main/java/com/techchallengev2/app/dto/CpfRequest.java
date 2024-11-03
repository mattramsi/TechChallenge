package com.techchallengev2.app.dto;

public class CpfRequest {
    private String cpf;

    public CpfRequest() {
    }
    public CpfRequest(String cpf) {
        this.cpf = cpf;
    }

    // Getter e Setter
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}