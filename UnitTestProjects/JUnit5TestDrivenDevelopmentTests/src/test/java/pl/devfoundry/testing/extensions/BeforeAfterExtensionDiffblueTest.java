package pl.devfoundry.testing.extensions;

import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.engine.descriptor.JupiterEngineDescriptor;
import org.junit.jupiter.engine.descriptor.JupiterEngineExtensionContext;
import org.junit.platform.engine.EngineExecutionListener;
import org.junit.platform.engine.UniqueId;

class BeforeAfterExtensionDiffblueTest {
    /**
     * Method under test: {@link BeforeAfterExtension#beforeEach(ExtensionContext)}
     */
    @Test
    void testBeforeEach() throws Exception {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Diffblue AI was unable to find a test

        // Arrange
        BeforeAfterExtension beforeAfterExtension = new BeforeAfterExtension();
        EngineExecutionListener engineExecutionListener = mock(EngineExecutionListener.class);

        // Act
        beforeAfterExtension.beforeEach(new JupiterEngineExtensionContext(engineExecutionListener,
                new JupiterEngineDescriptor(UniqueId.root("Segment Type", "42"))));
    }
}
