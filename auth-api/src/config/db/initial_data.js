import bcrypt from "bcrypt";
import User from "../../modules/users/infrastructure/models/user.js";

export async function createInitialData() {
    try {
        await User.sync({force: true});

        await User.create({
            name: "User test 1",
            email: "user@email.com",
            password: await bcrypt.hash("5369742", 10),
        });
    } catch (err) {
        console.error(err);
    }
}
