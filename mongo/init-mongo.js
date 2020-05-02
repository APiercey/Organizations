db.createUser({
  user: "root",
  pwd: "pass",
  roles: [
    role: "read-write",
    db: "eventstore_db"
  ]
})
