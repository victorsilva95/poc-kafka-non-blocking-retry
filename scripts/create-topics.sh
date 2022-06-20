kafkaCreateTopics="docker exec anime-kafka /kafka/bin/kafka-topics.sh --create --topic {topic} --bootstrap-server kafka:9092 --replication-factor 1 --partitions 1"

${kafkaCreateTopics/"{topic}"/anime}

