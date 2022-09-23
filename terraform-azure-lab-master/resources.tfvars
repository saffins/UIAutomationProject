# Variable Definition - RG, Location
rg_name  = "FC-TST-RG-01"
location = "UK South"
rs_tags = {
  "Project"     = "FC"
  "Environment" = "TST"
}

# Variable Definition - IaaS Resources
vnet_name = "FC-TST-VNET-01"
vnet_cidr = ["10.0.0.0/16"]
snet_name = ["FC-TST-WEB-SNET", "FC-TST-APP-SNET", "FC-TST-DBS-SNET"]
snet_cidr = [["10.0.1.0/24"], ["10.0.2.0/24"], ["10.0.3.0/24"]]
nsg_name  = ["FC-TST-WEB-SNET-NSG", "FC-TST-APP-SNET-NSG", "FC-TST-DBS-SNET-NSG"]
nsg_rules = [
  { "rule_name" = "Rule-01", "priority" = "100", "ingress_port" = "80" },
  { "rule_name" = "Rule-02", "priority" = "101", "ingress_port" = "443" }
]
avset_names = ["FC-TST-AST-01", "FC-TST-AST-02"]

# Variable Definition - PaaS Resources
appsp_names = ["FC-TST-ASP-01", "FC-TST-ASP-02"]

# Variable Definition - Database Resources
sqlsvr_name = "fc-tst-sqlsvr-01"
epool_name  = "fc-tst-epool-01"

# Variable Definition - Storage Resources
sa_name = "fctstsa01s"