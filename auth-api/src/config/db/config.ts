import {Sequelize} from "sequelize";

const database = process.env.DATABASE || "auth-db";
const username = process.env.USERNAME || "admin";
const host = process.env.HOST || "localhost";
const password = process.env.PASSWORD || "123456";

const sequelize = new Sequelize(
    database, username, password, {
    host,
    dialect: "postgres",
    quoteIdentifiers: false,
    define: {
        timestamps: false,
        underscored: true,
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
