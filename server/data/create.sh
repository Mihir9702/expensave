#!/bin/bash
export PGPASSWORD='postgres'
BASEDIR=$(dirname $0)
DATABASE=expensave
psql -U postgres -f "$BASEDIR/dropdb.sql" &&
createdb -U postgres $DATABASE &&
psql -U postgres -d $DATABASE -f "$BASEDIR/schema.sql" &&
psql -U postgres -d $DATABASE -f "$BASEDIR/data.sql"
