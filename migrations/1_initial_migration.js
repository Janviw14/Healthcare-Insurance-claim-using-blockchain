const Migrations = artifacts.require("Migrations");
const Insure = artifacts.require("Insure");

module.exports = function (deployer) {
  deployer.deploy(Migrations);
};

module.exports = function (deployer) {
  deployer.deploy(Insure);
};
