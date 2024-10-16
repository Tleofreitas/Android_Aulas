package com.example.exkotlincontabancaria

// OU class ContaBancaria (agenciaP: String = "", contaP: String = "", senhaP: String = "") {
/* OU class ContaBancaria constructor(agenciaP: String = "", contaP: String = "", senhaP: String = "") {
    var agencia: String = ""
    var conta: String = ""
    var senha: String = ""
 */
class ContaBancaria (
    var agencia: String = "",
    var conta: String = "",
    var senha: String = ""
) {
    var usuarioAutenticado: Boolean = false
    var saldo: Double = 0.0

    init {
        println("Objeto Inicializado!")
        /*
        // Utilizado somente na class sem os atributos diretos
        this.agencia = agenciaP
        this.conta = contaP
        this.senha = senhaP */
        println("Agencia: $agencia - Conta: $conta - Senha: $senha")
        this.usuarioAutenticado = true
        println("Usuário autenticado!")
    }

    fun recuperarSaldo(): Double {
        if (usuarioAutenticado){
            return saldo
        } else {
            return 0.0
        }
    }

    fun depositar(valorDeposito: Double) {
        if (valorDeposito > 0) {
            saldo += valorDeposito
        }
    }

    fun sacar(valorSaque: Double) {
        if(valorSaque < saldo){
            saldo -= valorSaque
        }
    }

    fun extrato(dias: Int) {
        println("Extrato dos últimos $dias dias")
    }

    fun extrato(DataInicial: String, DataFinal: String) {
        println("Extrato intervalo $DataInicial e $DataFinal")
    }
}

fun main() {
    val conta = ContaBancaria("112", "725","102013")
    println("Saldo inicial: "+conta.recuperarSaldo())

    conta.depositar(200.0)
    println("Saldo após depósito: "+conta.recuperarSaldo())

    conta.sacar(150.0)
    println("Saldo após saque: ${conta.recuperarSaldo()}")

    conta.extrato(7)

    conta.extrato("01/10/2024", "10/10/2024")
}