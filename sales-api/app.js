import restify from 'restify';

const server = restify.createServer();
const env = process.env;
const PORT = env.PORT || 8082;

server.get('/api/status', (req, res, next) => {
    res.send(200, {
        service: 'Sales-API',
        status: 'UP'
    });
    next();
});

server.listen(PORT, () => {
    console.info(`Server started successfully at port ${PORT}`);
});