package com.example.trustnetvpn; 

import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class FaqActivity extends AppCompatActivity {

    private LinearLayout faqContainer;

    private final String[][] faqs = {
            {
                    "What is TrustNet VPN?",
                    "TrustNet VPN is an app designed to route your device's "
                    + "network traffic through a VPN server when a working "
                    + "VPN connection is configured."
            },
            {
                    "How do I connect to the VPN?",
                    "Open TrustNet VPN, select an available server, and tap "
                    + "the power button. Approve Android's VPN permission "
                    + "when prompted. A working server configuration and "
                    + "internet connection are required."
            },
            {
                    "Why is my VPN not connecting?",
                    "Check your internet connection, server configuration, "
                    + "server address, keys, and firewall settings. Make sure "
                    + "the VPN server is running and reachable."
            },
            {
                    "How do I change my server location?",
                    "Open the server list and select a configured server. "
                    + "Selecting a country flag alone does not create a "
                    + "working VPN server."
            },
            {
                    "Does TrustNet VPN protect my connection?",
                    "Protection depends on a successful VPN tunnel and a "
                    + "correct server configuration. Verify that traffic "
                    + "is routed through the tunnel before relying on it."
            },
            {
                    "Is TrustNet VPN free?",
                    "Check the plans and subscription details displayed "
                    + "inside the app for current pricing and available features."
            },
            {
                    "How do I disconnect?",
                    "Return to the home screen and turn off the power button. "
                    + "The app should stop its VPN tunnel and update the "
                    + "connection status."
            },
            {
                    "Does the VPN guarantee complete anonymity?",
                    "No VPN can guarantee complete anonymity. Your privacy "
                    + "also depends on the VPN provider, app permissions, "
                    + "websites you visit, and your device settings."
            }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);

        faqContainer = findViewById(R.id.faqContainer);

        TextView backButton = findViewById(R.id.btnFaqBack);
        backButton.setOnClickListener(v -> finish());

        for (String[] faq : faqs) {
            addFaqItem(faq[0], faq[1]);
        }
    }

    private void addFaqItem(String question, String answer) {
        LinearLayout card = new LinearLayout(this);
        card.setOrientation(LinearLayout.VERTICAL);
        card.setPadding(dp(16), dp(14), dp(16), dp(14));

        GradientDrawable background = new GradientDrawable();
        background.setColor(Color.rgb(20, 29, 49));
        background.setCornerRadius(dp(14));
        background.setStroke(dp(1), Color.rgb(43, 56, 80));
        card.setBackground(background);

        LinearLayout.LayoutParams cardParams =
                new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT
                );
        cardParams.bottomMargin = dp(12);
        card.setLayoutParams(cardParams);

        LinearLayout questionRow = new LinearLayout(this);
        questionRow.setOrientation(LinearLayout.HORIZONTAL);
        questionRow.setGravity(Gravity.CENTER_VERTICAL);

        TextView questionText = new TextView(this);
        questionText.setText(question);
        questionText.setTextColor(Color.WHITE);
        questionText.setTextSize(16);
        questionText.setTypeface(null, Typeface.BOLD);
        questionText.setGravity(Gravity.CENTER_VERTICAL);

        LinearLayout.LayoutParams questionParams =
                new LinearLayout.LayoutParams(
                        0,
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        1
                );
        questionText.setLayoutParams(questionParams);

        TextView arrow = new TextView(this);
        arrow.setText("+");
        arrow.setTextColor(Color.rgb(90, 160, 255));
        arrow.setTextSize(25);
        arrow.setGravity(Gravity.CENTER);
        arrow.setContentDescription("Expand answer");

        questionRow.addView(questionText);
        questionRow.addView(arrow);

        TextView answerText = new TextView(this);
        answerText.setText(answer);
        answerText.setTextColor(Color.rgb(190, 201, 221));
        answerText.setTextSize(14);
        answerText.setLineSpacing(dp(3), 1f);
        answerText.setPadding(0, dp(14), 0, dp(4));
        answerText.setVisibility(View.GONE);

        card.addView(questionRow);
        card.addView(answerText);

        View.OnClickListener toggle = v -> {
            boolean isExpanded =
                    answerText.getVisibility() == View.VISIBLE;

            answerText.setVisibility(
                    isExpanded ? View.GONE : View.VISIBLE
            );

            arrow.setText(isExpanded ? "+" : "−");
            arrow.setContentDescription(
                    isExpanded ? "Expand answer" : "Collapse answer"
            );
        };

        questionRow.setOnClickListener(toggle);
        card.setOnClickListener(toggle);

        faqContainer.addView(card);
    }

    private int dp(float value) {
        return (int) (value * getResources()
                .getDisplayMetrics().density + 0.5f);
    }
}
