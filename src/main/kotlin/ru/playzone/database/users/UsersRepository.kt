package ru.playzone.database.users

import org.jetbrains.exposed.sql.transactions.transaction

object UsersRepository {
    fun insert(userDTO: UserDTO) = transaction {
        UsersDAO.new {
            login = userDTO.login
            password = userDTO.password
            username = userDTO.username
            email = userDTO.email
        }
    }

    fun fetchUser(login: String): UserDTO? = transaction {
        UsersDAO.findById(login)?.run(::daoToDTO)
    }

    fun getAll() = transaction {
        UsersDAO.all().map(::daoToDTO)
    }

    private fun daoToDTO(dao: UsersDAO) = UserDTO(
        login = dao.login,
        password = dao.password,
        email = dao.email,
        username = dao.username
    )
}
