FROM postgres:14.4

RUN localedef -i pt_BR -c -f UTF-8 -A /usr/share/locale/locale.alias pt_BR.UTF-8

COPY ./datasources.sql /docker-entrypoint-initdb.d/