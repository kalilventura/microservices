import bcrypt from "bcrypt";
import User from "../../modules/users/infrastructure/models/user";

const isDev = process.env.NODE_ENV === 'development';

const initializeDatabase = async () => {
    try {
        await User.sync({alter: isDev});
    } catch (err) {
        console.error(err);
    }
};

const seedInitialData = async () => {
    try {
        await User.create({
            name: "User test 1",
            email: "user@email.com",
            password: await bcrypt.hash("5369742", 10),
        });
    } catch (err) {
        console.error(err);
    }
}

export {seedInitialData, initializeDatabase};