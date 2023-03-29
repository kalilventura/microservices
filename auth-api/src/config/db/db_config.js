import Sequelize from "sequelize";

console.log(process.env.PASSWORD);

const sequelize = new Sequelize(
    process.env.DATABASE || "auth-db",
    process.env.USERNAME || "admin",
    process.env.PASSWORD || "123456", {
    host: process.env.HOST || "localhost",
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
        syncOnAssociation: true,
        timestamps: false,
        underscored: true,
        underscoredAll: true,
        freezeTableName: true
    }
});

sequelize
.authenticate()
.then(() => console.log("Connection has been stablished"))
.catch((err) => {
    console.error("Unable to connect to the database: ", err);
});

export default sequelize;
