SELECT pg_terminate_backend(pid)
FROM pg_stat_activity
WHERE datname = 'expensave';

DROP DATABASE expensave;

DROP USER expensave_owner;
DROP USER expensave_appuser;
