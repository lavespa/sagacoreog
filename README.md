Demo Saga Coreography Mutui - Kafka Stream Classic

==================

Build
-----

docker buildx build --target=ordini-service -t sagacoreog/ordini-service:0.0.1 --load . &&\
docker buildx build --target=cucine-services -t sagacoreog/cucine-services:0.0.1 --load . &&\
docker buildx build --target=consegne-services -t sagacoreog/consegne-services:0.0.1 --load .

docker run -p 8090:8090 -d --name sagacoreo1 sagacoreog/ordini-service:0.0.1
docker run -p 8080:8080 -d --name sagacoreo2 sagacoreog/cucine-services:0.0.1
docker run -p 8070:8070 -d --name sagacoreo3 sagacoreog/consegne-services:0.0.1