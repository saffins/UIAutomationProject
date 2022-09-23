# Generate a random password for SQL Server
resource "random_string" "tst_sqlsvr_pwd" {
  length  = 16
  special = true
}

# Resource Specific Output Definition
output "sqlsvr_pwd" {
  value = random_string.tst_sqlsvr_pwd.result
  sensitive = true
}