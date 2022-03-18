namespace java uic

struct User {
    1: i32 id
    2: string firstName
    3: string lastName
    4: i32 age
    5: Contact contact
    6: binary avatar
    7: bool vip
    8: string alias
}

struct Contact {
   1: string phone,
   2: string email
}

service UserService {
   User getUser(1:i32 id)
}
