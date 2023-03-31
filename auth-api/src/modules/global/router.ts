import { Router as ExpressRouter } from 'express';
import cors from "cors";
import bodyParser from "body-parser";

export const Router = (
  apiRouter: ExpressRouter
): ExpressRouter => {
  const router = ExpressRouter();
  router
    .use(cors())
    .use(bodyParser.json())
    .use(
      bodyParser.urlencoded({
        extended: false
      })
    );
  router.use(apiRouter);

  return router;
};
