import {Router} from "express";
import * as controllers from "./controllers/index";

export const UserRouter = (
    findUserController: controllers.UserController,
): Router => {
    const apiRouter = Router();
    
    const v1Router = Router();

    v1Router.get("/users", findUserController.get);

    apiRouter.use("/api/v1", v1Router);

    return apiRouter;
};
