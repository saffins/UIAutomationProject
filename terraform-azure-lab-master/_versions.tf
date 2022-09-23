# Terraform block to configure Terraform and Provider Version
terraform {
  required_version = "~> 1.0.0" # To allow upgrade of 1.0.x versions.

  required_providers {
    azurerm = {
      source  = "hashicorp/azurerm"
      version = "=2.46.0"
    }
    random = {
      source  = "hashicorp/random"
      version = "3.0.0"
    }
  }
}