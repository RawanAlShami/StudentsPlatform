#BUILD FRONTEND CONTAINER IMAGE
FROM node:18.12.1-alpine as build
WORKDIR /dist/src/app
COPY . /dist/src/app
RUN npm install
RUN npm run build --prod

#DEPLOY THE IMAGE
FROM nginx:1.17.1-alpine
COPY --from=build /dist/src/app/dist/angular-frontend /usr/share/nginx/html
COPY ./nginx/nginx.conf /etc/nginx/conf.d/default.conf
