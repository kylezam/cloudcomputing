package com.cis3111.java_cloud_tool.Repositories;

import com.cis3111.java_cloud_tool.Entities.Entries;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface EntriesRepository extends CrudRepository<Entries,Long> {
    List<Entries> findAll();
}
