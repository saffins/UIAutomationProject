# Resource Block to create App Service Plan
resource "azurerm_app_service_plan" "tst_appsp" {
  for_each            = toset(var.appsp_names)
  name                = each.key # note: each.key and each.value are the same for a set
  location            = var.location
  resource_group_name = data.azurerm_resource_group.tst_rg.name
  kind                = "Windows"
  reserved            = false

  sku {
    tier = "Standard"
    size = "S1"
  }

  tags = {
    Project     = var.rs_tags["Project"]
    Environment = var.rs_tags["Environment"]
  }
}

# Resource Output
output "tst_asp_id" {
  value = [
    for instance in azurerm_app_service_plan.tst_appsp :
    instance.id
  ]
}

