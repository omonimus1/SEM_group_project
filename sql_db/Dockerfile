# Use the latest MySQL image
FROM mysql
# Set the working directory to /tmp
WORKDIR /tmp
# Copy all the files to the working directory of the container
COPY ./world/*.sql /tmp/
# Copy the world.sql to docker-entrypoint-initdb.d
COPY ./world/world.sql /docker-entrypoint-initdb.d
# Set the root password
ENV MYSQL_ROOT_PASSWORD example


