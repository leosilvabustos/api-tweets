FROM launcher.gcr.io/google/mongodb3:latest
RUN set -x \
	wget -q -O  "https://raw.githubusercontent.com/leosilvabustos/api-tweets/master/schemas.js" \
	mongo localhost:27017 schemas.js

# Expose the default port
EXPOSE 27017
# Default port to execute the entrypoint (MongoDB)
CMD ["--port 27017", "--smallfiles"]
# Set default container command
ENTRYPOINT usr/bin/mongod