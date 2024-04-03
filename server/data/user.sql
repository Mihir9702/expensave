CREATE USER expensave_owner
WITH PASSWORD 'expensaveowner_password';

GRANT ALL
ON ALL TABLES IN SCHEMA public
TO expensave_owner;

GRANT ALL
ON ALL SEQUENCES IN SCHEMA public
TO expensave_owner;

CREATE USER expensave_appuser
WITH PASSWORD 'expensave';

GRANT SELECT, INSERT, UPDATE, DELETE
ON ALL TABLES IN SCHEMA public
TO expensave_appuser;

GRANT USAGE, SELECT
ON ALL SEQUENCES IN SCHEMA public
TO expensave_appuser;
