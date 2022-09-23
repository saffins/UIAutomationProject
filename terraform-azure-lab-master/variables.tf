# Authentication Specific Variables
variable "azure_subscription_id" {}
variable "azure_client_id" {}
variable "azure_client_secret" {}
variable "azure_tenant_id" {}

# Variable Declaration - RG, Location
variable "rg_name" {
  description = "Azure Resouce Group Name"
}

variable "location" {
  description = "Azure Resouce Group Location"
  default     = "UK South"
}

variable "rs_tags" {
  description = "Azure Resource Tags"
  default = {
    "Project"     = "FC"
    "Environment" = "TST"
  }
}

# Variable Declaration - IaaS Resources
variable "vnet_name" {}
variable "vnet_cidr" {}
variable "snet_name" {}
variable "snet_cidr" {}
variable "nsg_name" {}
variable "nsg_rules" {}
variable "avset_names" {}

# Variable Declaration - PaaS Resources
variable "appsp_names" {}

# Variable Declaration - Database Resources
variable "sqlsvr_name" {}
variable "epool_name" {}

# Variable Declaration - Storage Resources
variable "sa_name" {
  description = "Name of the storage account"
  validation {
    condition = (
      length(var.sa_name) >= 3 && length(var.sa_name) <= 24 && can(regex("^[a-z0-9]*$", var.sa_name))
    )
    error_message = "Storage account name can only consist of lowercase letters and numbers, and must be between 3 and 24 characters long."
  }
}

