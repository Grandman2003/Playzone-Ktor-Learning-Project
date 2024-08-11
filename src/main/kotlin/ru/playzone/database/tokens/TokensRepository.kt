package ru.playzone.database.tokens

import org.jetbrains.exposed.sql.transactions.transaction

object TokensRepository {
    fun insert(tokenDTO: TokenDTO) = transaction {
        TokensDAO.new {
            login =  tokenDTO.login
            token =  tokenDTO.token
            tokenId = tokenDTO.id

        }
    }

    fun fetchTokens() = transaction {
        TokensDAO.all().map(::daoToDTO)
    }

    private fun daoToDTO(dao: TokensDAO) = TokenDTO(
        login = dao.login,
        token = dao.token,
        id = dao.tokenId
    )
}