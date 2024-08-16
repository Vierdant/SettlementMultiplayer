package settlementmultiplayer.inventory.form;

import necesse.engine.network.client.Client;
import necesse.gfx.forms.components.FormComponent;
import necesse.gfx.forms.components.FormFlow;
import necesse.gfx.forms.components.FormHorizontalToggle;
import necesse.gfx.forms.components.localComponents.FormLocalLabel;
import necesse.gfx.forms.presets.containerComponent.settlement.SettlementContainerForm;
import necesse.gfx.forms.presets.containerComponent.settlement.SettlementDefendZoneForm;
import settlementmultiplayer.inventory.container.SettlementModContainer;

public class SettlementModDefendZoneForm<T extends SettlementModContainer> extends SettlementDefendZoneForm<T> {
    private FormHorizontalToggle explosionDamageToggle;

    public SettlementModDefendZoneForm(Client client, T container, SettlementContainerForm<T> containerForm) {
        super(client, container, containerForm);
        FormFlow flow = new FormFlow(getHeight());
        int toggleX = 0;
        int labelX = 0;
        for (FormComponent comp : getComponents()) {
            if (comp instanceof FormHorizontalToggle) {
                toggleX = ((FormHorizontalToggle) comp).getX();
            } else if (comp instanceof FormLocalLabel) {
                labelX = ((FormLocalLabel) comp).getX();
            }
        }

        setHeight(flow.next());
    }
}
