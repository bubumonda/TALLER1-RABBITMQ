FROM node:20.12.1-alpine3.19

WORKDIR /app

COPY /yarn.lock /package.json ./

RUN yarn install

COPY . .


CMD ["node", "fanout-exchange.js"]
