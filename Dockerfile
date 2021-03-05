from flyway/flyway:7

COPY src/main/resources/db/migration /flyway/sql

ENTRYPOINT ["flyway"]
CMD ["-?"]