# Local variables to follow DRY
locals {
  rg_name  = data.azurerm_resource_group.tst_rg.name
  location = var.location
}

# Resource block to deploy PaaS SQL Server
resource "azurerm_mssql_server" "tst_sqlsvr" {
  name                = var.sqlsvr_name
  resource_group_name = local.rg_name
  location            = local.location
  version             = "12.0"

  administrator_login          = join("", [var.sqlsvr_name, "-admin"])
  administrator_login_password = random_string.tst_sqlsvr_pwd.result

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}

# Resource block to deploy Elastic Pool
# az sql elastic-pool list-editions -l uksouth -o table | To get the SKU details
resource "azurerm_mssql_elasticpool" "tst_epool" {
  name                = var.epool_name
  resource_group_name = local.rg_name
  location            = local.location
  server_name         = azurerm_mssql_server.tst_sqlsvr.name
  max_size_gb         = 50

  sku {
    name     = "StandardPool"
    tier     = "Standard"
    capacity = 50
  }

  per_database_settings {
    min_capacity = 0
    max_capacity = 50
  }

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}