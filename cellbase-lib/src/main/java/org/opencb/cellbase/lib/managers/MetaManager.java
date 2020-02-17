/*
 * Copyright 2015-2020 OpenCB
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opencb.cellbase.lib.managers;

import org.opencb.cellbase.core.api.core.CellBaseDBAdaptor;
import org.opencb.cellbase.core.config.CellBaseConfiguration;
import org.opencb.cellbase.core.result.CellBaseDataResult;
import org.opencb.commons.datastore.core.Query;
import org.opencb.commons.datastore.core.QueryOptions;

public class MetaManager extends AbstractManager {

    private CellBaseDBAdaptor cellBaseDBAdaptor;

    public MetaManager(CellBaseConfiguration configuration) {
        super(configuration);
        this.init();
    }

    private void init() {
        cellBaseDBAdaptor = dbAdaptorFactory.getMetaDBAdaptor(species, assembly);
    }

    public CellBaseDataResult getVersions(QueryOptions queryOptions) {
        return cellBaseDBAdaptor.nativeGet(new Query(), queryOptions);
    }
}
