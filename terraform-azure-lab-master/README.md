# Terraform Code Sets
This repository contains Terraform code for Individual Resource deployment on Azure Public Cloud.

## Prerequisites:
Resources in this repository are meant for use with Terraform 1.0.0 (Check the version using below command). If you don't have the compatible version, download it from official Terraform repository.

	terraform --version

## Requirements

### Software

-   [Terraform](https://www.terraform.io/downloads.html) >= 1.0.0
-   [terraform-provider-azurerm] plugin = 2.46.0
-   [terraform-provider-random] plugin = 3.0.0

## Execution:
For multiple environment provisioning, use different tfstate files in backend. To execute the Terraform code, go to command prompt and then run the following commands:

-   [Required] `terraform init`
    -   To initialize the terraform with remote backend, use "-backend-config=PATH" flag partial backend configuration. To specify a single key/value pair, use the -backend-config="KEY=VALUE" option when running terraform init.

-   [Optional] `terraform validate`
    -   To check whether a configuration is syntactically valid and internally consistent, regardless of any provided variables or existing state.

-   [Optional] `terraform fmt`
    -   The terraform fmt command is used to rewrite Terraform configuration files to a canonical format and style. use "-recursive" flag to format the code inside all folders.

-   [Optional] `terraform plan -var-file="resource.tfvars" -out=tfplan`
    -   It creates an execution plan. You can use the optional -out=FILE option to save the generated plan to a file on disk, which you can later execute by passing the file to terraform apply as an extra argument.

-   [Required] `terraform apply -var-file="resource.tfvars" -auto-approve`
    -   It executes the actions proposed in a Terraform plan. In the default case, with no saved plan file, Terraform will prompt you to approve the plan before taking the described actions, unless you override that prompt using the -auto-approve option. Terraform ignores the -auto-approve flag when you pass a previously-saved plan file, because Terraform considers you passing the plan file as the approval.

-   [Optional] `terraform destroy -target="resource_type.resource_name"`
    -   The terraform destroy command is used to destory the resources defined in your Terraform configuration. To delete the specific resource, use the "target" option with destroy command.

## Reference:

> https://medium.com/@gmusumeci/getting-started-with-terraform-and-microsoft-azure-a2fcb690eb67
