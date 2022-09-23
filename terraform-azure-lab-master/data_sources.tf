# Data Sources to be used

# Data block to read info of existing Resource Group
data "azurerm_resource_group" "tst_rg" {
  name = var.rg_name
}

# Resource specific output
output "tst_rg_id" {
  value = data.azurerm_resource_group.tst_rg.id
}