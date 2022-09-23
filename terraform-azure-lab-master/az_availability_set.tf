# Resource block to deploy Availability Set
resource "azurerm_availability_set" "tst_avset" {
  count               = length(var.avset_names)
  name                = var.avset_names[count.index]
  location            = var.location
  resource_group_name = data.azurerm_resource_group.tst_rg.name

  platform_update_domain_count = 5
  platform_fault_domain_count  = 2

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}

# Resource specific outputs
output "tst_avset_ids" {
  value = azurerm_availability_set.tst_avset.*.id
}

output "tst_avset_01_id" {
  value = azurerm_availability_set.tst_avset.0.id
}

output "tst_avset_02_id" {
  value = azurerm_availability_set.tst_avset.1.id
}