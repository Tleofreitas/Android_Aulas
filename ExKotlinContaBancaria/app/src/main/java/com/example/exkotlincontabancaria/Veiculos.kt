package com.example.exkotlincontabancaria

enum class Status {
    FUNCIONAMENTO, MANUTENCAO, QUEBRADO
}

interface Eletrificado {
    fun motorEletrico()
}

abstract class Veiculo(
    open var nome: String? = null,
    open var qtdRodas: Int? = null
) {
    open fun acelerar() = print("Acelerar ")
    open fun acelerar(Velocidade: Int) = print("Acelerar com $Velocidade Km/h o veículo ")

    abstract fun recuperarStatus()
}

class Carro(
    override var nome: String? = null,
    override var qtdRodas: Int? = null,
    var status: Status = Status.FUNCIONAMENTO
) : Veiculo() {
    override fun acelerar() {
        super.acelerar()
        println("$nome com $qtdRodas rodas")
    }

    override fun acelerar(Velocidade: Int) {
        super.acelerar(Velocidade)
        println("$nome com $qtdRodas rodas")
    }

    override fun recuperarStatus() = println("O status do veículo é: $status ")

    companion object {
        const val VELOCIDADE_MAX_PERMITIDA = 80
        fun exibeMensagemVelocidadeMaximaLei() {
            println("A velocidade máxima é: $VELOCIDADE_MAX_PERMITIDA")
        }
    }
}

class Moto(
    override var nome: String? = null,
    override var qtdRodas: Int? = null,
    var status: Status = Status.FUNCIONAMENTO
) : Veiculo(), Eletrificado {
    override fun acelerar() {
        super.acelerar()
        println("$nome com $qtdRodas rodas")

        motorEletrico()
    }

    override fun acelerar(Vecolidade: Int) {
        super.acelerar(Vecolidade)
        println("$nome com $qtdRodas rodas")
    }

    override fun motorEletrico() = println("Rodando com motor elétrico")

    override fun recuperarStatus() = println("O status do veículo é: $status ")

    companion object {
        const val VELOCIDADE_MAX_PERMITIDA = 100
        fun exibeMensagemVelocidadeMaximaLei() {
            println("A velocidade máxima é: $VELOCIDADE_MAX_PERMITIDA")
        }
    }
}

fun main() {
    println("--- Meu Carro ---")
    val meuCarro = Carro("Corsa", 4);
    meuCarro.acelerar();
    meuCarro.status = Status.MANUTENCAO
    meuCarro.recuperarStatus()
    Carro.exibeMensagemVelocidadeMaximaLei()

    println("\n--- Minha Moto ---")
    val minhaMoto = Moto("CB300", 2);
    minhaMoto.acelerar(50)
    minhaMoto.recuperarStatus()
    Moto.exibeMensagemVelocidadeMaximaLei()
}