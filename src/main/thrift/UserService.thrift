namespace java uic

struct User {
    1: i32 id,
    2: string firstName
    3: string lastName
    4: i32 age
}

service UserService {
   User getUser(1:i32 id)
}
