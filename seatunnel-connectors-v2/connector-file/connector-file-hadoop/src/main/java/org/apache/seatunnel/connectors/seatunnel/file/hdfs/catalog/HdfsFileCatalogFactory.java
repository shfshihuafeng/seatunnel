package org.apache.seatunnel.connectors.seatunnel.file.hdfs.catalog;

import com.google.auto.service.AutoService;
import org.apache.seatunnel.api.configuration.ReadonlyConfig;
import org.apache.seatunnel.api.configuration.util.OptionRule;
import org.apache.seatunnel.api.table.catalog.Catalog;
import org.apache.seatunnel.api.table.factory.CatalogFactory;
import org.apache.seatunnel.api.table.factory.Factory;
import org.apache.seatunnel.connectors.seatunnel.file.config.FileBaseSourceOptions;
import org.apache.seatunnel.connectors.seatunnel.file.config.FileSystemType;
import org.apache.seatunnel.connectors.seatunnel.file.config.HadoopConf;
import org.apache.seatunnel.connectors.seatunnel.file.hadoop.HadoopFileSystemProxy;
import org.apache.seatunnel.connectors.seatunnel.file.hdfs.source.config.HdfsSourceConfigOptions;

@AutoService(Factory.class)
public class HdfsFileCatalogFactory  implements CatalogFactory {
    @Override
    public Catalog createCatalog(String catalogName, ReadonlyConfig options) {
        String hdfsNameKey = options.get(HdfsSourceConfigOptions.DEFAULT_FS);
        HadoopFileSystemProxy fileSystemUtils = new HadoopFileSystemProxy(new HadoopConf(hdfsNameKey));
        return new HdfsFileCatalog(
                fileSystemUtils, options.get(FileBaseSourceOptions.FILE_PATH), factoryIdentifier());
    }

    @Override
    public String factoryIdentifier() {
        return FileSystemType.HDFS.getFileSystemPluginName();
    }

    @Override
    public OptionRule optionRule() {
        return  OptionRule.builder().build();
    }
}
