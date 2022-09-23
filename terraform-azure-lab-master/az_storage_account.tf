# Resource block to deploy Storage Account
resource "azurerm_storage_account" "tst_storage" {
  name                     = var.sa_name
  resource_group_name      = data.azurerm_resource_group.tst_rg.name
  location                 = var.location
  account_tier             = "Standard"
  account_replication_type = "GRS"

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}