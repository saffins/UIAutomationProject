# Resource block to deploy Virtual Network
resource "azurerm_virtual_network" "tst_vnet" {
  name                = var.vnet_name
  location            = var.location
  resource_group_name = data.azurerm_resource_group.tst_rg.name
  address_space       = var.vnet_cidr

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}

# Resource block to deploy Subnets
resource "azurerm_subnet" "web_snet" {
  name                 = var.snet_name[0]
  resource_group_name  = data.azurerm_resource_group.tst_rg.name
  virtual_network_name = azurerm_virtual_network.tst_vnet.name
  address_prefixes     = var.snet_cidr[0]
}

resource "azurerm_subnet" "app_snet" {
  name                 = var.snet_name[1]
  resource_group_name  = data.azurerm_resource_group.tst_rg.name
  virtual_network_name = azurerm_virtual_network.tst_vnet.name
  address_prefixes     = var.snet_cidr[1]
}

resource "azurerm_subnet" "dbs_snet" {
  name                 = var.snet_name[2]
  resource_group_name  = data.azurerm_resource_group.tst_rg.name
  virtual_network_name = azurerm_virtual_network.tst_vnet.name
  address_prefixes     = var.snet_cidr[2]
}