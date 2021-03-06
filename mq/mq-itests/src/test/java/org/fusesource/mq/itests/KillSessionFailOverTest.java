/**
 * Copyright (C) FuseSource, Inc.
 * http://fusesource.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.fusesource.mq.itests;

import org.apache.karaf.tooling.exam.options.LogLevelOption;
import org.fusesource.fabric.api.Container;
import org.fusesource.fabric.api.FabricService;
import org.fusesource.fabric.itests.paxexam.support.ContainerBuilder;
import org.fusesource.fabric.itests.paxexam.support.Provision;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.ExamReactorStrategy;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.ops4j.pax.exam.options.DefaultCompositeOption;
import org.ops4j.pax.exam.spi.reactors.AllConfinedStagedReactorFactory;

import java.util.Arrays;
import java.util.Set;

import static org.apache.karaf.tooling.exam.options.KarafDistributionOption.keepRuntimeFolder;
import static org.apache.karaf.tooling.exam.options.KarafDistributionOption.logLevel;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;


@RunWith(JUnit4TestRunner.class)
@ExamReactorStrategy(AllConfinedStagedReactorFactory.class)
public class KillSessionFailOverTest extends GracefullFailOverTest {



    void setupCluster(String groupName, String brokerName) throws Exception {
        System.out.println(executeCommand("fabric:mq-create --group " + groupName + " " + brokerName));
        String profileName = "mq-broker-"+groupName+"."+brokerName;
        System.out.println(executeCommand("fabric:profile-edit --features fabric-zookeeper-commands " + profileName));
        Set<Container> containers = ContainerBuilder.child(2).withName("child").withProfiles(profileName).assertProvisioningResult().build();
    }


    void failOver(FabricService fabricService, String container) throws Exception {
        System.out.println(executeCommand("fabric:container-connect -u admin -p admin " + container + " zk:kill"));
    }



    @Configuration
    public Option[] config() {
        return new Option[]{
                new DefaultCompositeOption(mqDistributionConfiguration()), keepRuntimeFolder(),
                logLevel(LogLevelOption.LogLevel.INFO)
        };
    }
}
