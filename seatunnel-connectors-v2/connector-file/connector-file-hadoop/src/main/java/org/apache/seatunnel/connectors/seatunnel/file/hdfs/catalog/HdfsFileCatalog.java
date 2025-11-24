package org.apache.seatunnel.connectors.seatunnel.file.hdfs.catalog;

import org.apache.seatunnel.connectors.seatunnel.file.catalog.AbstractFileCatalog;
import org.apache.seatunnel.connectors.seatunnel.file.hadoop.HadoopFileSystemProxy;

public class HdfsFileCatalog extends AbstractFileCatalog {
    protected HdfsFileCatalog(HadoopFileSystemProxy hadoopFileSystemProxy, String filePath, String catalogName) {
        super(hadoopFileSystemProxy, filePath, catalogName);
    }
}
