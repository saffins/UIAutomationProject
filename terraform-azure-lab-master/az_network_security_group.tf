# Resource block to deploy Network Security Groups
resource "azurerm_network_security_group" "tst_web_snet_nsg" {
  name                = var.nsg_name[0]
  location            = var.location
  resource_group_name = data.azurerm_resource_group.tst_rg.name

  dynamic "security_rule" {
    for_each = var.nsg_rules
    content {
      name                       = security_rule.value["rule_name"]
      priority                   = security_rule.value["priority"]
      direction                  = "Inbound"
      access                     = "Allow"
      protocol                   = "Tcp"
      source_port_range          = "*"
      destination_port_range     = security_rule.value["ingress_port"]
      source_address_prefix      = "*"
      destination_address_prefix = "10.0.1.0/24"
    }
  }

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}