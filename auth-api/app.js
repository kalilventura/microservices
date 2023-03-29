import * as dotenv from "dotenv";
dotenv.config();

import express from "express";
import * as db from "./src/config/db/initial_data.js";

const app = express();
const env = process.env;
const PORT = env.PORT || 8080;

db.createInitialData();

app.get("/api/status", (req, res) => {
    return res.status(200).json({
        service: "Auth-API",
        status: "UP"
    });
});

app.listen(PORT, () => {
    console.info(`Server started at port ${PORT}`);
});