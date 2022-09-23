# Terraform
Terraform is a popular cloud agnostic IaC (Infrastructure as a Code) tool. Cloud-agnostic – meaning it lets us deploy and manage infrastructure across a variety of public cloud providers such as AWS, Azure and Google Cloud Platform.
Different cloud providers have their native IaC tool as well such as Cloud Formation for AWS, ARM Templates & Bicep for Azure and Google Deployment Manager for GCP.

## Variable Precedence
If the same variable is assigned multiple values, Terraform uses the last value it finds, overriding any previous values.

Terraform loads variables in the following order, with later sources taking precedence over earlier ones:

1. Environment variables
2. The terraform.tfvars file, if present.
3. The terraform.tfvars.json file, if present.
4. Any *.auto.tfvars or *.auto.tfvars.json files, processed in lexical order of their filenames.
5. Any -var and -var-file options on the command line, in the order they are provided. (This includes variables set by a Terraform Cloud workspace.)

Declaring a variable means you are gonna use a variable & Defining a variable means that you are giving a variable a value.
The *.tf file is used to declare that the variable exists whereas The *.tfvars files are used to define variables and then specify that variable definition file on the command line with -var-file.


## Terraform Commands:
For multiple environment provisioning, use different tfstate files in backend. To execute the Terraform code, go to command prompt and then run the following commands:

[Required] `terraform init`
> To initialize the terraform with remote backend, use "-backend-config=PATH" flag partial backend configuration. To specify a single key/value pair, use the -backend-config="KEY=VALUE" option when running terraform init.

[Optional] `terraform validate`
> To check whether a configuration is syntactically valid and internally consistent, regardless of any provided variables or existing state.

[Optional] `terraform fmt`
> The terraform fmt command is used to rewrite Terraform configuration files to a canonical format and style. use "-recursive" flag to format the code inside all folders.

[Optional] `terraform plan -var-file="resource.tfvars" -out=tfplan`
> It creates an execution plan. You can use the optional -out=FILE option to save the generated plan to a file on disk, which you can later execute by passing the file to terraform apply as an extra argument.

[Required] `terraform apply -var-file="resource.tfvars" -auto-approve`
> It executes the actions proposed in a Terraform plan. In the default case, with no saved plan file, Terraform will prompt you to approve the plan before taking the described actions, unless you override that prompt using the -auto-approve option. 
Terraform ignores the -auto-approve flag when you pass a previously-saved plan file, because Terraform considers you passing the plan file as the approval.
	
[Optional] `terraform state list`
> The command will list all resources in the state file matching the given addresses (if any). If no addresses are given, all resources are listed.

[Optional] `terraform output`
> The terraform output command is used to extract the value of an output variable from the state file.

[Optional] `terraform show`
> The terraform show command is used to provide human-readable output from a state or plan file. This can be used to inspect the current state as Terraform sees it.

[Optional] `terraform destroy -target="resource_type.resource_name"`
> The terraform destroy command is used to destory the resources defined in your Terraform configuration. To delete the specific resource, use the "target" option with destroy command.

## Reference:

> https://medium.com/@gmusumeci/getting-started-with-terraform-and-microsoft-azure-a2fcb690eb67