package com.natsu.elixirs.client.render;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.vertex.PoseStack;
import com.natsu.elixirs.Elixirs;
import com.natsu.elixirs.client.render.FrozenSolidHandler.FrozenSolidLayer;
import com.natsu.elixirs.common.registry.ElixirsEffects;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.PlayerModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.player.PlayerRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction.Axis;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.ai.attributes.DefaultAttributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.PlayerModelPart;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RenderHandEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.util.ObfuscationReflectionHelper;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Elixirs.MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class FrozenLayerRenderEvent {

    
	@SubscribeEvent
    public static void onAddLayers(EntityRenderersEvent.AddLayers event) {
        List<EntityType<? extends LivingEntity>> entityTypes = ImmutableList.copyOf(
                ForgeRegistries.ENTITY_TYPES.getValues().stream()
                        .filter(DefaultAttributes::hasSupplier)
                        .map(entityType -> (EntityType<? extends LivingEntity>) entityType)
                        .collect(Collectors.toList()));
        entityTypes.forEach((entityType -> {
            addLayerIfApplicable(entityType, event);
        }));
        for (String skinType : event.getSkins()){
            event.getSkin(skinType).addLayer(new FrozenSolidHandler.FrozenSolidLayer(event.getSkin(skinType)));
        }
    }

	private static void addLayerIfApplicable(EntityType<? extends LivingEntity> entityType, EntityRenderersEvent.AddLayers event) {
	    if (entityType == EntityType.ENDER_DRAGON) return;
	    try {
	        LivingEntityRenderer renderer = event.getRenderer(entityType);
	        if (renderer != null) {
	            renderer.addLayer(new FrozenSolidHandler.FrozenSolidLayer(renderer));
	        }
	    } catch (Exception e) {
	        // certains types d'entités n'ont pas de renderer humanoïde : on les ignore
	    }
	}
	
	/*@SubscribeEvent
    public void onRenderHand(RenderHandEvent event) {
        event.getPoseStack().pushPose();

        Player player = Minecraft.getInstance().player;

        if(player != null) {
            if (player.hasEffect(ElixirsEffects.FROZEN_SOLID.get())) {
                boolean isMainHand = event.getHand() == InteractionHand.MAIN_HAND;   
                if (isMainHand && !player.isInvisible() && event.getItemStack().isEmpty()) {
                    HumanoidArm enumhandside = isMainHand ? player.getMainArm() : player.getMainArm().getOpposite();
                    renderArmFirstPersonFrozen(event.getPoseStack(), event.getMultiBufferSource(), event.getPackedLight(), event.getEquipProgress(), event.getSwingProgress(), enumhandside);
                    event.setCanceled(true);
                }
            }
        }

        event.getPoseStack().popPose();
    }*/

    /**
     * From ItemRenderer#renderArmFirstPerson
     * @param swingProgress
     * @param equippedProgress
     * @param side
     */
    /*private void renderArmFirstPersonFrozen(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, float equippedProgress, float swingProgress, HumanoidArm side) {
        Minecraft mc = Minecraft.getInstance();
        EntityRenderDispatcher renderManager = mc.getEntityRenderDispatcher();
        Minecraft.getInstance().getTextureManager().bindForSetup(FrozenSolidHandler.FROZEN_OVERLAY);
        boolean flag = side != HumanoidArm.LEFT;
        float f = flag ? 1.0F : -1.0F;
        float f1 = Mth.sqrt(swingProgress);
        float f2 = -0.3F * Mth.sin(f1 * (float)Math.PI);
        float f3 = 0.4F * Mth.sin(f1 * ((float)Math.PI * 2F));
        float f4 = -0.4F * Mth.sin(swingProgress * (float)Math.PI);
        matrixStackIn.translate(f * (f2 + 0.64000005F), f3 + -0.6F + equippedProgress * -0.6F, f4 + -0.71999997F);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f * 45.0F));
        float f5 = Mth.sin(swingProgress * swingProgress * (float)Math.PI);
        float f6 = Mth.sin(f1 * (float)Math.PI);
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f * f6 * 70.0F));
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f * f5 * -20.0F));
        AbstractClientPlayer abstractclientplayerentity = mc.player;
        mc.getTextureManager().bindForSetup(abstractclientplayerentity.getSkinTextureLocation());
        matrixStackIn.translate(f * -1.0F, 3.6F, 3.5D);
        matrixStackIn.mulPose(Axis.ZP.rotationDegrees(f * 120.0F));
        matrixStackIn.mulPose(Axis.XP.rotationDegrees(200.0F));
        matrixStackIn.mulPose(Axis.YP.rotationDegrees(f * -135.0F));
        matrixStackIn.translate(f * 5.6F, 0.0D, 0.0D);
        PlayerRenderer playerrenderer = (PlayerRenderer)renderManager.getRenderer(abstractclientplayerentity);
        if (flag) {
            playerrenderer.renderRightHand(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity);
            matrixStackIn.scale(1.02f, 1.02f, 1.02f);
            this.renderRightArm(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity, playerrenderer.getModel());
        } else {
            playerrenderer.renderLeftHand(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity);
            matrixStackIn.scale(1.02f, 1.02f, 1.02f);
            this.renderLeftArm(matrixStackIn, bufferIn, combinedLightIn, abstractclientplayerentity, playerrenderer.getModel());
        }
    }

    public void renderRightArm(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn, PlayerModel<AbstractClientPlayer> model) {
        this.renderItem(matrixStackIn, bufferIn, combinedLightIn, playerIn, (model).rightArm, (model).rightSleeve, model);
    }

    public void renderLeftArm(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn, PlayerModel<AbstractClientPlayer> model) {
        this.renderItem(matrixStackIn, bufferIn, combinedLightIn, playerIn, (model).leftArm, (model).leftSleeve, model);
    }

    private void renderItem(PoseStack matrixStackIn, MultiBufferSource bufferIn, int combinedLightIn, AbstractClientPlayer playerIn, ModelPart rendererArmIn, ModelPart rendererArmwearIn, PlayerModel<AbstractClientPlayer> model) {
        this.setModelVisibilities(playerIn, model);
        model.attackTime = 0.0F;
        model.crouching = false;
        model.swimAmount = 0.0F;
        model.setupAnim(playerIn, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        rendererArmwearIn.xRot = 0.0F;
        rendererArmwearIn.render(matrixStackIn, bufferIn.getBuffer(RenderType.entityTranslucent(FrozenSolidHandler.FROZEN_OVERLAY)), combinedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 0.8f);
    }

    private void setModelVisibilities(AbstractClientPlayer clientPlayer, PlayerModel<AbstractClientPlayer> playermodel) {
        if (clientPlayer.isSpectator()) {
            playermodel.setAllVisible(false);
            playermodel.head.visible = true;
            playermodel.hat.visible = true;
        } else {
            playermodel.setAllVisible(true);
            playermodel.hat.visible = clientPlayer.isModelPartShown(PlayerModelPart.HAT);
            playermodel.jacket.visible = clientPlayer.isModelPartShown(PlayerModelPart.JACKET);
            playermodel.leftPants.visible = clientPlayer.isModelPartShown(PlayerModelPart.LEFT_PANTS_LEG);
            playermodel.rightPants.visible = clientPlayer.isModelPartShown(PlayerModelPart.RIGHT_PANTS_LEG);
            playermodel.leftSleeve.visible = clientPlayer.isModelPartShown(PlayerModelPart.LEFT_SLEEVE);
            playermodel.rightSleeve.visible = clientPlayer.isModelPartShown(PlayerModelPart.RIGHT_SLEEVE);
            playermodel.crouching = clientPlayer.isCrouching();
        }
    }*/
	
}
