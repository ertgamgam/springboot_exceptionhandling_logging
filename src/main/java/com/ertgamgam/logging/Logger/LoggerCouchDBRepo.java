package com.ertgamgam.logging.Logger;

import org.springframework.data.couchbase.core.query.N1qlPrimaryIndexed;
import org.springframework.data.couchbase.core.query.ViewIndexed;
import org.springframework.data.couchbase.repository.CouchbasePagingAndSortingRepository;

@N1qlPrimaryIndexed
@ViewIndexed(designDoc = "logmessage")
public interface LoggerCouchDBRepo extends CouchbasePagingAndSortingRepository<LogMessage,String> {
}
